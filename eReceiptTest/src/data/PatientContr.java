package data;

import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.Objects;

final public class PatientContr {


    private final BigDecimal aportation;


    public PatientContr(BigDecimal aportation) throws InvalidParameterException {

        if(aportation == null ||
            aportation.compareTo(new BigDecimal(0)) == -1 ||
            aportation.compareTo(new BigDecimal(100)) == 1){

            throw new InvalidParameterException("Invalid aportation");
        } else {
        this.aportation = aportation;

        }
    }

    public BigDecimal getAportation() {
        return aportation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PatientContr)) return false;
        PatientContr that = (PatientContr) o;
        return Objects.equals(getAportation(), that.getAportation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAportation());
    }

    @Override
    public String toString() {
        return "PatientContr{" +
                "aportation=" + aportation +
                '}';
    }
}
