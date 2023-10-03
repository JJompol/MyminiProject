package Project.NewPorject;

public class Comparison {
    public static String compareTaxes(double progressiveTax, double flatTax) {
        String result;
        if (progressiveTax < flatTax) {
            result = "ภาษีที่ต้องจ่ายคือ ภาษีแบบเหมา: " + flatTax + " บาท";
        } else if (progressiveTax > flatTax) {
            result = "ภาษีที่ต้องจ่ายคือ ภาษีแบบขั้นบรรได: " + progressiveTax + " บาท";
        } else {
            result = "เลือกจ่ายภาษีแบบใดแบบนึง";
        }
        return result;
    }
}