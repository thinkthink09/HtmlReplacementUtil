public class HtmlReplacementUtil {

  public static String replaceAllTags(String htmlText) {

    // htmlText = htmlText.replaceAll("</li>", "\n");
    // htmlText = htmlText.replaceAll("</p>", "\n");

    htmlText = htmlText.replaceAll("<br[\\s]{0,2}/>", "\n");
    htmlText = htmlText.replaceAll("<(?!\\/?a(?=>|\\s.*>))\\/?.*?>", "");
    htmlText = htmlText.replaceAll("&nbsp;", " ");
    htmlText = htmlText.replaceAll("&rdquo;", ">");
    htmlText = htmlText.replaceAll("&ldquo;", "<");
    if (htmlText.startsWith("\n")) {
      htmlText = htmlText.replaceFirst("\\s++", "");
    }
    return htmlText;
  }

  public static String replaceAllTagsAndAnchor(String htmlText) {

    htmlText = replaceAllTags(htmlText);
    htmlText = htmlText.replaceAll("<.*?>", "");
    return htmlText;
  }

  public static String makeUlLi(String linesOfString) {

    StringBuilder htmlText = new StringBuilder();
    htmlText.append("<ul>");

    for (String string : linesOfString.split("\n")) {
      htmlText.append("<li>" + string + "</li>");
    }
    htmlText.append("</ul>");
    return htmlText.toString();
  }

  public static String makeUlLi(String linesOfString, String className) {

    StringBuilder htmlText = new StringBuilder();
    htmlText.append("<ul class='" + className + "'>");

    for (String string : linesOfString.split("\n")) {
      htmlText.append("<li>" + string + "</li>");
    }
    htmlText.append("</ul>");
    return htmlText.toString();
  }

  public static String makeBr(String linesOfString) {

    if (isNotEmpty(linesOfString)) {

      StringBuilder htmlText = new StringBuilder();

      for (String string : linesOfString.split("\n")) {
        htmlText.append(string + "<br>");
      }
      return htmlText.toString();
    } else {

      return "";
    }
  }

  public static String makeP(String linesOfString) {

    if (isNotEmpty(linesOfString)) {

      StringBuilder htmlText = new StringBuilder();

      for (String string : linesOfString.split("\n")) {
        htmlText.append("<p>" + string + "</p>");
      }
      return htmlText.toString();
    } else {

      return "";
    }
  }
}
