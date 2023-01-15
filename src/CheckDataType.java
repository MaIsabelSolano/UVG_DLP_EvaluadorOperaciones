public class CheckDataType {

    public CheckDataType() {

    }

    public String check(String element){

        String tipoData = element.getClass().getSimpleName();

        try {

            Integer element2 = Integer.parseInt(element);

            tipoData = element2.getClass().getSimpleName();
            
        } catch (Exception e) {
            // TODO: handle exception
        }

        return tipoData;
    }

}