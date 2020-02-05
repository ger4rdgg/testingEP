package pharmacy;

import data.ProductID;

import java.util.*;

public class Dispensing {

    private byte nOrder;
    private Date initDate, finalDate;
    private boolean isCompleted;
    private Set<MedicineDispensingLine> medicineDispensingLines = new HashSet<>();

    public Dispensing(byte nOrder, Date initDate, Date finalDate) {
        this.nOrder = nOrder;
        this.initDate = initDate;
        this.finalDate = finalDate;
        this.isCompleted = false;
    }

    public void addMedicine(MedicineDispensingLine medicine){
        medicineDispensingLines.add(medicine);
    }


    public boolean dispensingEnabled() throws DispensingNotAviableException{

        Date date = new Date();
        if(date.after(initDate) && date.before(finalDate))
            return true;
        else
            throw new DispensingNotAviableException("Out of date");
    }
    public void setProductAsDispensed(ProductID prodID){

        for(Iterator<MedicineDispensingLine> it = medicineDispensingLines.iterator(); it.hasNext();){

            MedicineDispensingLine mdl = it.next();
            if(mdl.getProdid().equals(prodID)){
                mdl.setAdquiredTrue();
            }

        }

    }


    public MedicineDispensingLine getMedicine(ProductID productID) {
        for(Iterator<MedicineDispensingLine> it = medicineDispensingLines.iterator(); it.hasNext();){

            MedicineDispensingLine mdl = it.next();
            if(mdl.getProdid().equals(productID)){
                return mdl;
            }
        }
        return null;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(){
        this.isCompleted = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dispensing)) return false;
        Dispensing that = (Dispensing) o;
        return nOrder == that.nOrder &&
                isCompleted() == that.isCompleted() &&
                Objects.equals(initDate, that.initDate) &&
                Objects.equals(finalDate, that.finalDate) &&
                Objects.equals(medicineDispensingLines, that.medicineDispensingLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nOrder, initDate, finalDate, isCompleted(), medicineDispensingLines);
    }
}
