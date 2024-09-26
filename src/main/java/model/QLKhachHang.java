package model;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import util.FileHelper;
/*
  Tác giả: Họ tên sinh viên
*/
public class QLKhachHang {

    private ArrayList<KhachHang> dsKhachHang;

    public QLKhachHang() {
        dsKhachHang = new ArrayList<>();
    }

    public QLKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

    public ArrayList<KhachHang> getDsKhachHang() {
        return dsKhachHang;
    }

    public void setDsKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

    //sinh viên cải đặt cho các phương thức xử lý sau
   
    public void DocKhachHang(String filename) {
        ArrayList<String> data = FileHelper.readFileText(filename);
        dsKhachHang.clear();
        for (String item : data) {
            String[] arr = item.split(";");
            KhachHang kh = new KhachHang();
            kh.setMaso(arr[0]);
            kh.setHoten(arr[1]);
            kh.setLoai(Integer.parseInt(arr[2]));
            kh.setChisocu(Double.parseDouble(arr[3]));
            kh.setChisomoi(Double.parseDouble(arr[4]));
            dsKhachHang.add(kh); 
        }
    }

    public boolean GhiHoaDon(String filename) {
        
        ArrayList<String> data = new ArrayList<>();
        for (KhachHang kh : dsKhachHang) {
            String info = kh.getMaso() + ";" + kh.getHoten() + ";" + kh.getLoai() + ";" + kh.getChisocu()+ ";" + kh.getChisomoi()+ ";" + kh.getTieuThu()+ ";" + kh.getTienTra();
            data.add(info);
        }
        return FileHelper.writeFileText(filename, data);
    
    }
   
    public void sapXepTheoLoaiHinh() {
             Comparator<KhachHang> cmpb = (khach1, khach2) -> {
            return Double.compare(khach1.getLoai(),khach2.getLoai());
        };
        Collections.sort(dsKhachHang, cmpb);
       
    }
    
    public double getTieuThuCaoNhat()
    {
      return 0;    
    }
    
    public KhachHang getTieuThuThapNhat()
    {
      if(dsKhachHang.isEmpty()){
          return null;
      } 
      KhachHang TieuThuThapNhat=dsKhachHang.get(0);
      for(KhachHang kh :dsKhachHang){
          if(kh.getTieuThu()<TieuThuThapNhat.getTieuThu()){
          TieuThuThapNhat=kh;
          }
      }
      return TieuThuThapNhat;
    }
    
    public double getTieuThuTrungBinh()
    {
      if(dsKhachHang.isEmpty()){
          return 0;
      } 
      double trungbinh=0;
      for(KhachHang kh :dsKhachHang){
          trungbinh=kh.getTieuThu();
          
      } 
      return trungbinh;
    }
}
