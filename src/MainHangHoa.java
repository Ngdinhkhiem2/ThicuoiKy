import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class MainHangHoa {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Date ngayNhap = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        LinkedLIST listHangHoa = new LinkedLIST();
        listHangHoa.DuLieuMacDinh();
        do{
            System.out.println("--------------------------MENU----------------------------");
            System.out.println("-1---------------------ADD PRODUCT-----------------------");
            System.out.println("-2--------------------DELETE PRODUCT-----------------------");
            System.out.println("-3--------------------FIXING PRODUCT-----------------------");
            System.out.println("-4--------------------ARRANGE PRODUCT---------------------");
            System.out.println("-5------------------STATISTICS PRODUCT---------------------");
            System.out.println("-6-----------------SHOWING THE PRODUCT LIST-------------------");
            System.out.println("-7------------------SEARCHING FOR PRODUCT---------------------");
            System.out.println("-0------------------------EXIT--------------------------");
            System.out.println("ENTERING YOUR CHOICES:");
            int lc = sc.nextInt();
            switch(lc)
            {
                case 0:
                    break;
                case 1:
                String loaiHh = null;
                sc.nextLine();
                System.out.println("ENTER THE PRODUCT NAME:");
                String ten = sc.nextLine();
                System.out.println("INTO THE NUMBER OF PRODUCT:");
                int soLuong = sc.nextInt();
                System.out.println("INTO PRODUCT PRICES:");
                float gia = sc.nextFloat();
                System.err.println("INTO THE KIND OF PRODUCT[1: Thuc Pham; 2: Sanh Su; 3: Dien May]");
                int l = sc.nextInt();
                switch(l)
                {
                    case 1: loaiHh = "Thuc Pham";
                    break;
                    case 2: loaiHh = "Sanh Su";
                    break;
                    case 3: loaiHh = "Dien May";
                    break;
                    default: System.out.println("WRONG PRODUCT!!!");
                    break;
                }
                sc.nextLine();
                try {
                    System.out.println("ENTER DATE OF DELIVERY [dd/MM/yyyy]");
                    ngayNhap = df.parse(sc.nextLine());
                } catch (Exception e) {
                    System.out.println("ILLEGAL DATE!!!");
                }
                HangHoa hangHoa = new HangHoa(soLuong, ten, loaiHh, gia, ngayNhap);
                listHangHoa.ThemHangHoa(hangHoa);
                    break;
                case 2:
                System.out.println("Enter ID needs deletion:");
                int xoa = sc.nextInt();
                listHangHoa.XoaHangHoa(xoa);
                    break;
                case 3:
                System.out.println();
                int sua = sc.nextInt();
                listHangHoa.SuaThongTin(sua);
                    break;
                case 4:
                listHangHoa.SapXepGiamDan();
                    break;
                case 5:
                listHangHoa.Thongke();
                    break;
                case 6:
                listHangHoa.HienThiHangHoa();
                    break;
                case 7:
                System.out.println("TO FOLLOW THE KIND OF PRODUCT");
                int lll = sc.nextInt();
                switch(lll)
                {
                    case 1:
                    System.out.println("Choose What Product Want to Find [1: Thuc Pham; 2: Sanh Su; 3: Dien May]");
                    System.out.println("PICK A NUMBER:");
                    int l1 = sc.nextInt();
                    String ll = null;
                    switch(l1){
                        case 1: ll = "Thuc Pham";
                        break;
                        case 2: ll = "Sanh Su";
                        break;
                        case 3: ll = "Dien May";
                        break;
                        default: System.out.println("ERROR!!");
                        break;
                    }
                    listHangHoa.TimKiemTheoLoai(ll);
                    break;
                default:
                System.out.println("ERROR!!!");
                System.out.println("Please Choose Again");
                break;
                }
            }
        }while(true);
    }
    
}
