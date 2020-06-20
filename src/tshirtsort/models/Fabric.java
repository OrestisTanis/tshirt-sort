package tshirtsort.models;

public enum Fabric {
    WOOL, COTTON, POLYESTER, RAYON, LINEN, CASHMERE, SILK;

    public float getFabricPrice(int ordinal) {
        float result;
        switch (ordinal) {
            case 0:
                result = 2.5f;
                break;
            case 1:
                result = 4.5f;
                break;
            case 2:
                result = 5f;
                break;
            case 3:
                result = 7.5f;
                break;
            case 4:
                result = 8.2f;
                break;
            case 5:
                result = 9.3f;
                break;
            default:
                result = 22f;
                break;
        }
        return result;
    }
}
