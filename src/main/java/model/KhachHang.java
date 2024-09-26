package model;

import java.util.Objects;

/*
  Tác giả: Hồ Văn Tự
 */
public class KhachHang {

    private String maso;
    private String hoten;
    private int loai;
    private double chisocu;
    private double chisomoi;

    public KhachHang() {
    }

    public KhachHang(String maso) {
        this.maso = maso;
    }

    public KhachHang(String maso, String hoten, int loai, double chisocu, double chisomoi) {
        this.maso = maso;
        this.hoten = hoten;
        this.loai = loai;
        this.chisocu = chisocu;
        this.chisomoi = chisomoi;
    }

    public String getMaso() {
        return maso;
    }

    public void setMaso(String maso) {
        this.maso = maso;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getLoai() {
        return loai;
    }

    public void setLoai(int loai) {
        this.loai = loai;
    }

    public double getChisocu() {
        return chisocu;
    }

    public void setChisocu(double chisocu) {
        this.chisocu = chisocu;
    }

    public double getChisomoi() {
        return chisomoi;
    }

    public void setChisomoi(double chisomoi) {
        this.chisomoi = chisomoi;
    }

    //sinh viên cài đặt xử lý cho các phương thức sau    
    public double getTieuThu() {
        double tieuthu = chisomoi - chisocu;
        return tieuthu;
    }
    public double getTienTra() {
        double tieuThu = getTieuThu();
        double TraTien = 0;      
           if (loai == 1) {
            TraTien = tieuThu * 4575;
        }        
        else if (loai == 2) {
            if (tieuThu <= 50) {
                TraTien = tieuThu * 1806;
            } else if (loai==2 &tieuThu <= 100) {
                TraTien = 50 * 1806 + (tieuThu - 50) * 1866;
            } else if (loai==3&tieuThu <= 200) {
                TraTien = 50 * 1806 + 50 * 1866 + (tieuThu - 100) * 2167;
            } else if (loai==4&tieuThu <= 300) {
                TraTien = 50 * 1806 + 50 * 1866 + 100 * 2167 + (tieuThu - 200) * 2729;
            } else if (loai==5&tieuThu <= 400) {
                TraTien = 50 * 1806 + 50 * 1866 + 100 * 2167 + 100 * 2729 + (tieuThu - 300) * 3050;
            } else {
                TraTien = 50 * 1806 + 50 * 1866 + 100 * 2167 + 100 * 2729 + 100 * 3050 + (tieuThu - 400) * 3151;
            }
        }        
        TraTien += TraTien * 0.08;
        return TraTien;
    }
     @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KhachHang other = (KhachHang) obj;
        return Objects.equals(this.maso, other.maso);
    }
}
