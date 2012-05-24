@WebService(name = "ExempleService")
public class ExempleService {
    @WebMethod(operationName = "afficher")
    public String afficher(
        @WebParam(name = "texte") String texte){
        ...
    }
}
