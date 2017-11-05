public class Element {
    private String inputType;
    private String placeholder;
    private String height;
    private String width;
    private String fontSize;
    private String leftPosition;
    private String topPosition;

    public Element() {
        inputType = "";
        placeholder = "";
        height = "";
        width = "";
        fontSize = "";
        leftPosition = "";
        topPosition = "";
    }

    public Element(String input, String text, String h, String w, String f, String l, String t) {
        inputType = input;
        placeholder = text;
        height = h;
        width = w;
        fontSize = f;
        leftPosition = l;
        topPosition = t;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }

    public void setLeftPosition(String leftPosition) {
        this.leftPosition = leftPosition;
    }

    public void setTopPosition(String topPosition) {
        this.topPosition = topPosition;
    }

    public String getInputType() {
        return inputType;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public String getHeight() {
        return height;
    }

    public String getWidth() {
        return width;
    }

    public String getFontSize() {
        return fontSize;
    }

    public String getLeftPosition() {
        return leftPosition;
    }

    public String getTopPosition() {
        return topPosition;
    }
}
