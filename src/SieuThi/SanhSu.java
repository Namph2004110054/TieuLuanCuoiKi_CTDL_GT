package SieuThi;

import java.sql.Date;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class SanhSu {
    private int maHang;
    private String tenHang;
    private double donGia;
    private Date nSX, hSD;

    public  SanhSu (int maHang, String tenHang, double donGia, Date nSX, Date hSD) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.donGia = donGia;
        this.nSX = nSX;
        this.hSD = hSD; }

        
        public SanhSu() { 
        }
        public int getMaHang() {
            return maHang;
        }
     
        public void setMaHang(int maHang) {
            this.maHang = maHang;
        }
     
        public String getTenHang() {
            return tenHang;
        }
     
        public void setTenHang(String tenHang) {
            this.tenHang = tenHang;
        }
     
        public double getDonGia() {
            return donGia;
        }
     
        public void setDonGia(double donGia) {
            this.donGia = donGia;
        }
     
        public Date getnSX() {
            return nSX;
        }
     
        public void setnSX(Date nSX) {
            this.nSX = nSX;
        }
     
        public Date gethSD() {
            return hSD;
        }
     
        public void sethSD(Date hSD) {
            this.hSD = hSD;
        }
    public String toString() {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localeVN);
        String str = numberFormat.format(donGia);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String str1 = simpleDateFormat.format(nSX);
        String str2 = simpleDateFormat.format(hSD);
        return "Thông tin về Sành Sứ: \n" +
                "2 : " + maHang +
                "\nLy,Chén,Bát : '" + tenHang +
                "\n50.000VND : " + str +
                "\n20/08/2021 : " + str1 +
                "\n20/01/2022 : " + str2;
    }
    public void setNSX(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        this.nSX = (Date) calendar.getTime();
    }
    public void setHSD(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        this.hSD = (Date) calendar.getTime();
    }
    public boolean kiemTraTenHang(boolean k) {
        if (this.tenHang == "" || this.tenHang.isEmpty()) {
            System.out.println("Ly,Chén,Bát : ");
        } else {
            k = false;
        }
        return k;
    }
    public boolean kiemTraNgay(boolean t) {
        if (this.getnSX().compareTo(this.gethSD()) < 0) {
            t = false;
        } else {
            System.out.println("20/01/2022 : ");
        }
        return t;
    }
    public void kiemTraHSD() {
        Date today = new Date(maHang);
        today.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String st = simpleDateFormat.format(today);
        if (this.gethSD().compareTo(today) < 0) {
            System.out.println("20/08/2021 " + st + ", 20/01/2022 ");
        } else {
            System.out.println("20/08/2021 " + st + ", 20/01/2022 ");
        }
    }
public class Main {
    public void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            SanhSu tp = new SanhSu();
            boolean kt = true;
            boolean th = true;
            System.out.println("2 : ");
            tp.setMaHang(scanner.nextInt());
            scanner.nextLine();
            do {
                System.out.println("Ly,Chén,Bát : ");
                tp.setTenHang(scanner.nextLine());
            } while (tp.kiemTraTenHang(kt));
            System.out.println("50.000VND : ");
            tp.setDonGia(scanner.nextDouble());
            do {
                System.out.println("20/08/2021 : ");
                tp.setNSX(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                System.out.println("20/01/2022 : ");
                tp.setHSD(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            } while (tp.kiemTraNgay(th));
            System.out.println(tp);
            tp.kiemTraHSD();
        }
    }
}

}