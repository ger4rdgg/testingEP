package pharmacy;

import data.ProductID;

public class MedicineDispensingLine{

    private ProductID prodid;
    private boolean adquired = false;

    public MedicineDispensingLine(ProductID prodid) {
        this.prodid = prodid;
    }

    public void setAdquiredTrue() {
        this.adquired = true;
    }
}
