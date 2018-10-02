package xfinity.com.comcastcodeassignment.model;

public class CharacterModel {

    private String text;

    private Icon icon;

    public boolean isUseGrid() {
        return useGrid;
    }

    public void setUseGrid(boolean useGrid) {
        this.useGrid = useGrid;
    }

    private boolean useGrid = false;

    /**
     * No args constructor for use in serialization
     *
     */
    public CharacterModel() {
    }

    /**
     *
     * @param icon Icon object of the showcharater
     * @param text text contains title and description
     */
    public CharacterModel(String text, Icon icon) {
        this.text = text;
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    /**
     *
     * @param text description contains title and detail
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     *
     * @return an Icon object
     */
    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
}
