package ifellow.tools;

public class PagerDataHelper {
    public int getPagesCount(String data) {
        return Integer.parseInt(data.split(" ")[2]);
    }
}
