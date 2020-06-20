package tshirtsort.models;

public enum Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET;

    public float getColorPrice(int ordinal) {
        float result;
        switch (ordinal) {
            case 0:
                result = 0.05f;
                break;
            case 1:
                result = 0.1f;
                break;
            case 2:
                result = 0.15f;
                break;
            case 3:
                result = 0.2f;
                break;
            case 4:
                result = 0.25f;
                break;
            case 5:
                result = 0.3f;
                break;
            default:
                result = 0.35f;
                break;
        }
        return result;
    }
}
