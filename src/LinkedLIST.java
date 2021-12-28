import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class LinkedLIST {
    private Node head, tail;
    HangHoa hangHoa = new HangHoa();
    Date ngayNhap = new Date();
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    public LinkedLIST()
    {
        hangHoa.autoId = 1;
        this.head = null;
        this.tail = null;
    }
    public boolean isEmpty()
    {
        return this.head == null;
    }
    public void ThemHangHoa(HangHoa hangHoa)
    {
        if(isEmpty())
        {
            this.head = this.tail = new Node(hangHoa);
            return;
        }
        Node newNode = new Node(hangHoa);
        this.tail.setNext(newNode);
        this.tail = newNode;

    }
    public void HienThiHangHoa()
    {
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+PRODUCT INFORMATION+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        System.out.printf("%-20S %-20S %-20S %-20S %-20S %-20S\n", "ma hang", "ten hang", "so luong", "gia hang", "loai hang", "ngay nhap kho");
        Node node = this.head;
        while(node != null){
            System.out.printf("%-20d %-20S %-15d %-7.3fVNĐ %20S %20S\n", node.getHangHoa().iD, node.getHangHoa().tenHangHoa, node.getHangHoa().soLuong, node.getHangHoa().giaHang, node.getHangHoa().getLoai(),df.format(node.getHangHoa().ngayNhap)); 
            node = node.getNext();
        }
    }
    public void ThemNhieuHangHoa(HangHoa...hangHoas)
    {
        for(HangHoa hangHoa : hangHoas)
        {
            ThemHangHoa(hangHoa);
        }
    }
    public boolean TimKiemTheoLoai(String ll){
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+PRODUCT INFORMATION+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        System.out.printf("%-20S %-20S %-20S %-20S %-20S %-20S\n", "ma hang", "ten hang", "so luong", "gia hang", "loai hang", "ngay nhap kho");
        boolean isFound = false;
        Node node = this.head;
        while(node != null)
        {
            if(node.getHangHoa().getLoai().contains(ll))
            {
                
                System.out.printf("%-20d %-20S %-15d %-7.3fVNĐ %20S %20S\n", node.getHangHoa().iD, node.getHangHoa().tenHangHoa, node.getHangHoa().soLuong, node.getHangHoa().giaHang, node.getHangHoa().getLoai(),df.format(node.getHangHoa().ngayNhap));
                isFound = true;
            }
            node = node.getNext();
        }
        if(!isFound)
        {
            System.out.println("ERROR, Can't Find Product !!!");
            return false;
        }
        return true;
    }
    public boolean SuaThongTin(int id){
        Node node = this.head;
        while(node != null)
        {
            if(node.getHangHoa().getiD() == id)
            {
                String loaiHh = null;
                System.out.println("ENTER THE PRODUCT NAME:");
                String ten = sc.nextLine();
                System.out.println("INTO THE NUMBER OF PRODUCT:");
                int soLuong = sc.nextInt();
                System.out.println("INTO PRODUCT PRICES:");
                float gia = sc.nextFloat();
                System.out.println("INTO THE KIND OF PRODUCT[1: Thuc Pham; 2: Sanh Su; 3: Dien May]");
                int l = sc.nextInt();
                switch(l)
                {
                    case 1: loaiHh = "Thuc Pham";
                    break;
                    case 2: loaiHh = "Sanh Su";
                    break;
                    case 3: loaiHh = "Dien May";
                    break;
                    default: System.out.println("ERROR!!!");
                    break;
                }
                sc.nextLine();
                try {
                    System.out.println("ENTER DATE OF DELIVERY [dd/MM/yyyy]");
                    ngayNhap = df.parse(sc.nextLine());
                } catch (Exception e) {
                    System.out.println("ILLEGAL DATE!!!");
                }
                node.getHangHoa().setTenHangHoa(ten);
                node.getHangHoa().setSoLuong(soLuong);
                node.getHangHoa().setGiaHang(gia);
                node.getHangHoa().setLoai(loaiHh);
                node.getHangHoa().setNgayNhap(ngayNhap);
                return true;
            }
            node = node.getNext();
        }
        System.out.println("ERROR,Can't Fix It !!!");
        return false;
    }
    
    public boolean XoaHangHoa(int id)
    {
        Node node = this.head;
        if(this.head.getHangHoa().getiD() == id){
            this.head = this.head.getNext();
            System.out.println("Deleted The First Product !!!");
            return true;
        }
        else{
            System.out.println("The Product Has Been Erased !!!");
        }
        while(node != null)
        {
            if(node.getNext().getHangHoa().getiD() == id){
                node.setNext(node.getNext().getNext());
                System.out.println("Successful Deletion !!!");
                return true;
            }
            else{
                System.out.println("ID Doesn't Exist !!!");
            }
            node = node.getNext();
        }
        System.out.println("Erased Unsuccessfully !!!");
        return false;
    }
    public void SapXepGiamDan(){
        Node node = this.head, node2 = null;
        HangHoa tempHangHoa;
        if(head == null)
        return;
        else{
            while(node != null){
                node2 = node.next;
                while(node2 != null){
                    if(node.hangHoa.giaHang > node2.hangHoa.giaHang){
                        tempHangHoa = node.hangHoa;
                        node.hangHoa = node2.hangHoa;
                        node2.hangHoa = tempHangHoa;
                    }
                    node2 = node2.next;
                }
                node = node.next;
            }
        }
        HienThiHangHoa();
    }
    public void Thongke(){
        Node node = this.head;
        int sLtemp = 0;
        float gTtemp = 0;
        while(node != null){
            sLtemp += node.getHangHoa().getSoLuong();
            gTtemp += node.getHangHoa().getGiaHang();
            node = node.getNext();
        }

        System.out.println("+-+-+-+-+-+-+-+-+STATISTICS+-+-+-+-+-+-+-+-+-");
        System.out.printf("%-30S %-30S\n", "Tong so luong", "Tong Gia Tri");
        System.out.printf("%-30d %-30.3fVNĐ\n", sLtemp, gTtemp);
    }
    public void DuLieuMacDinh(){
        try {
            String sDate1 = "20/12/2021";  
            String sDate2 = "12/12/2021";  
            String sDate3 = "10/12/2021";  
            String sDate4 = "19/12/2021";  
            String sDate5 = "21/12/2021";  
            String sDate6 = "01/12/2021";  
            SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");  
            Date date1=formatter1.parse(sDate1);  
            Date date2=formatter1.parse(sDate2);  
            Date date3=formatter1.parse(sDate3);  
            Date date4=formatter1.parse(sDate4);  
            Date date5=formatter1.parse(sDate5);  
            Date date6=formatter1.parse(sDate6); 
            HangHoa hangHoa1 = new HangHoa(1000, "binh gom", "Sanh Su", 200, date4);
            HangHoa hangHoa2 = new HangHoa(20000, "nuoc mia", "Thuc Pham", 5, date5);
            HangHoa hangHoa3 = new HangHoa(500, "loa", "Dien May", 500, date3);
            HangHoa hangHoa4 = new HangHoa(1500, "tivi", "Dien May", 1000, date3);
            HangHoa hangHoa5 = new HangHoa(1000, "rau muong", "Thuc Pham", 5, date2);
            HangHoa hangHoa6 = new HangHoa(1000, "rau sach", "Thuc Pham", 3, date5);
            HangHoa hangHoa7 = new HangHoa(1000, "laptop", "Dien May", 15000, date4);
            HangHoa hangHoa8 = new HangHoa(1000, "my tuong den", "Thuc Pham", 6, date1);
            HangHoa hangHoa9 = new HangHoa(1000, "noi nung", "Sanh Su", 15, date3);
            HangHoa hangHoa10 = new HangHoa(1000, "may nuoc nong", "Dien May", 2000, date5);
            HangHoa hangHoa11 = new HangHoa(1000, "chen su", "Sanh Su", 10, date1);
            HangHoa hangHoa12 = new HangHoa(10000, "Shushimi", "Thuc Pham", 20, date3);
            HangHoa hangHoa13 = new HangHoa(100, "ca mat trang", "Thuc Pham", 7000, date2);
            HangHoa hangHoa14 = new HangHoa(1000, "chau nuoc", "Sanh Su", 90, date4);
            HangHoa hangHoa15 = new HangHoa(10, "thit bo kobe", "Thuc Pham", 250000, date1);
            HangHoa hangHoa16 = new HangHoa(10, "trung ca tam", "Thuc Pham", 600000, date4);
            HangHoa hangHoa17 = new HangHoa(1000, "voi sen", "Dien May", 165, date2);
            HangHoa hangHoa18 = new HangHoa(1, "vuong mien", "Sanh Su", 1000000, date6);
            HangHoa hangHoa19 = new HangHoa(1000, "may tinh ban", "Dien May", 20000, date3);
            HangHoa hangHoa20 = new HangHoa(1000, "may hut bui", "Dien May", 21000, date5);
            ThemHangHoa(hangHoa1);
            ThemHangHoa(hangHoa2);
            ThemHangHoa(hangHoa3);
            ThemHangHoa(hangHoa4);
            ThemHangHoa(hangHoa5);
            ThemHangHoa(hangHoa6);
            ThemHangHoa(hangHoa7);
            ThemHangHoa(hangHoa8);
            ThemHangHoa(hangHoa9);
            ThemHangHoa(hangHoa10);
            ThemHangHoa(hangHoa11);
            ThemHangHoa(hangHoa12);
            ThemHangHoa(hangHoa13);
            ThemHangHoa(hangHoa14);
            ThemHangHoa(hangHoa15);
            ThemHangHoa(hangHoa16);
            ThemHangHoa(hangHoa17);
            ThemHangHoa(hangHoa18);
            ThemHangHoa(hangHoa19);
            ThemHangHoa(hangHoa20);
        } catch (Exception e) {
            e.getCause();
        }
    }
    
}
