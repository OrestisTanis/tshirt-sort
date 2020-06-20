package tshirtsort.models;

public enum Size {
    XS, S, M, L, XL, XXL, XXXL;
    
    public float getSizePrice(int ordinal) {
        float result;
        switch (ordinal) {
            case 0:
                result = 0.22f;
                break;
            case 1:
                result = 0.23f;
                break;
            case 2:
                result = 0.25f;
                break;
            case 3:
                result = 0.3f;
                break;
            case 4:
                result = 0.35f;
                break;
            case 5:
                result = 0.4f;
                break;
            default:
                result = 0.6f;
                break;
        }
        return result;
    }
}
