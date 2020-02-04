package data;


import java.security.InvalidParameterException;
import java.util.Objects;

final public class HealthCardID {

    private final String personalID;


    public HealthCardID(String code) throws InvalidParameterException {

        if(code == null || code.equals("InvalidCode")){
            throw new InvalidParameterException("Codigo invalido");
        }else {
            this.personalID = code;
        }
    }

    public String getPersonalID() {
        return personalID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HealthCardID)) return false;
        HealthCardID that = (HealthCardID) o;
        return Objects.equals(getPersonalID(), that.getPersonalID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPersonalID());
    }

    @Override
    public String toString() {
        return "HealthCardID{" +
                "personalID='" + personalID + '\'' +
                '}';
    }
}
