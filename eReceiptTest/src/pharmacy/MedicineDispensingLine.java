package pharmacy;

import data.ProductID;

import java.util.Objects;

public class MedicineDispensingLine{

    private ProductID prodid;
    private boolean adquired = false;

    public MedicineDispensingLine(ProductID prodid) {
        this.prodid = prodid;
    }

    public void setAdquiredTrue() {
        this.adquired = true;
    }

    public ProductID getProdid() {
        return prodid;
    }

    public boolean isAdquired() {
        return adquired;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MedicineDispensingLine)) return false;
        MedicineDispensingLine that = (MedicineDispensingLine) o;
        return adquired == that.adquired &&
                Objects.equals(prodid, that.prodid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prodid, adquired);
    }
}
