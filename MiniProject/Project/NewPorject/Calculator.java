package Project.NewPorject;

public class Calculator implements TaxInterface  {
        @Override
        public double calculateProgressiveTax(double netIncome) {
        double taxRate;
        // คำนวณภาษีแบบขั้นบันได
            if (netIncome <= 150000) {
                taxRate = 0.0; //ไม่ต้องจ่ายภาษี
            } else if (netIncome <= 300000) {
                taxRate = 0.05; //จ่ายภาษี 5%
            } else if (netIncome <= 500000) {
                    taxRate = 0.10; //จ่ายภาษี 10%
            } else if (netIncome <= 750000) {
                    taxRate = 0.15; //จ่ายภาษี 15%
            } else if (netIncome <= 1000000) {
                    taxRate = 0.20; //จ่ายภาษี 20%
            } else if (netIncome <= 2000000) {
                    taxRate = 0.25; //จ่ายภาษี 25%
            } else if (netIncome <= 5000000) {
                    taxRate = 0.30; //จ่ายภาษี30%
            } else {
                taxRate = 0.35; //จ่ายภาษี 35%
            }
        return netIncome * taxRate; // เงินได้สุทธิ * อัตตราภาษี
        }

        public double FlatTax(double totalIncome, double salary) {
            return (totalIncome - salary) * 0.005;
        }


        }
