package pharmacy;

import data.ProductID;

import java.util.Date;

public class Dispensing {

    private byte nOrder;
    private Date date;
    private boolean isCompleted;

    public Dispensing(byte nOrder) {
        this.nOrder = nOrder;
        this.date = new Date();
        this.isCompleted = false;
    }

    class MedicineDispensingLine{

        private ProductID prodid;
        private boolean adquired = false;

        public MedicineDispensingLine(ProductID prodid) {
            this.prodid = prodid;
        }

        public void setAdquiredTrue() {
            this.adquired = true;
        }
    }

    public void setCompleted(){
        this.isCompleted = true;
    }
}
