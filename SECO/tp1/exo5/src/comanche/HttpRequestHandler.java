package comanche;

import java.io.IOException;

public class HttpRequestHandler implements RequestHandler {
	@Override
	public void handleRequest(Request r) throws IOException {
		r.out.println("<html><meta http-equiv=\"refresh\" ; content=\"0 url=http://www.google.fr\" ></html>");
	}

}
