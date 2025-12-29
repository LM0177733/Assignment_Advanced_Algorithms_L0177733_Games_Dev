import java.util.Objects;

public class Address{
    private int houseNo;
    private String streetName;
    private String town;
    public Address(int houseNo, String streetName,String town){
this.houseNo=houseNo;
this.streetName=streetName;
this.town=town;
    }
    @Override
    public String toString()
    {
        return "Address{"+
        "houseNo='"+houseNo+'\''+
        ", streetName="+streetName+'\''+
        ", town="+town+'\''+
        '}';
    }
    @Override
    public boolean equals(Object o){    
        if(this==o) return true;
        if(o==null || getClass()!=o.getClass()) return false;
        Address address=(Address) o;
        return houseNo==address.houseNo && 
        streetName.equals(address.streetName) &&
        town.equals(address.town);
    }   
    @Override
    public int hashCode(){
        return Objects.hash(houseNo, streetName, town);
    }
}