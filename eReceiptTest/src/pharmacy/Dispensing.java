package pharmacy;

import data.ProductID;

import java.util.Date;

public class Dispensing {

    private byte nOrder;
    private Date initDate, finalDate;
    private boolean isCompleted;

    public Dispensing(byte nOrder, Date initDate, Date finalDate) {
        this.nOrder = nOrder;
        this.initDate = initDate;
        this.finalDate = finalDate;
        this.isCompleted = false;
    }

    public boolean dispensingEnabled() throws DispensingNotAviableException{

        Date date = new Date();
        if(date.after(initDate))
            return true;
        else
            throw new DispensingNotAviableException("Out of date");
    }
    public void setProductAsDispensed(ProductID prodID){

        MedicineDispensingLine mdl = new MedicineDispensingLine(prodID);
        mdl.setAdquiredTrue();

    }

    public void setCompleted(){
        this.isCompleted = true;
    }
}
