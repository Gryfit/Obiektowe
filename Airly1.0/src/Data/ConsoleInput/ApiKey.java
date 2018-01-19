package Data.ConsoleInput;

public class ApiKey {
    private String apiKey="";
    public ApiKey(String apiKey){
        this.apiKey=apiKey;
    }
    public boolean isEmpty(){
        return apiKey.isEmpty();
    }

    @Override
    public String toString() {
        return apiKey;
    }
}
