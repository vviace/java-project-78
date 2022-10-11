package hexlet.code.schemas;

public class StringSchema {
    public boolean status = true;
    public String containValue;

    public boolean isValid(Object obj){
        String str = "";
        if(obj != null) {
            str = obj.toString();
        }
        if(obj == null || str.length() == 0) {
            return status;
        }
        if(str.contains(containValue)) {
            return true;
        }
        return false;
    }
    public void required() {
        this.status = false;
    }
    public StringSchema contains(String value){
        this.containValue = value;
        return this;
    }
}
