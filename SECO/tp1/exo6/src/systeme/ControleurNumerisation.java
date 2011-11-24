package systeme;

import org.objectweb.fractal.api.NoSuchInterfaceException;
import org.objectweb.fractal.api.control.BindingController;
import org.objectweb.fractal.api.control.IllegalBindingException;
import org.objectweb.fractal.api.control.IllegalLifeCycleException;

import interfaces.RequestAlim;
import interfaces.RequestDoc;
import interfaces.RequestEnvoiNumerisation;
import interfaces.RequestImpression;
import interfaces.RequestNumerisation;

public class ControleurNumerisation implements RequestNumerisation, BindingController {
	private RequestImpression impression;
	private RequestDoc document;
	private RequestAlim alimentation;
	private RequestEnvoiNumerisation envoiNumerisation;
	
	@Override
	public void bindFc(String arg0, Object arg1)
			throws NoSuchInterfaceException, IllegalBindingException,
			IllegalLifeCycleException {
		if (arg0.equals("i")) {
			impression = (RequestImpression) arg1;
		} else if (arg0.equals("d")) {
			document = (RequestDoc) arg1;
		} else if (arg0.equals("a")) {
			alimentation = (RequestAlim) arg1;
		} else if (arg0.equals("e")) {
			envoiNumerisation = (RequestEnvoiNumerisation) arg1;
		}
	}

	@Override
	public String[] listFc() {
		return new String[] { "i", "d", "a", "e" };
	}

	@Override
	public Object lookupFc(String arg0) throws NoSuchInterfaceException {
		if (arg0.equals("i")) {
			return impression;
		} else if (arg0.equals("d")) {
			return document;
		} else if (arg0.equals("a")) {
			return alimentation;
		} else if (arg0.equals("e")){
			return envoiNumerisation;
		}
		return null;
	}

	@Override
	public void unbindFc(String arg0) throws NoSuchInterfaceException,
			IllegalBindingException, IllegalLifeCycleException {
		if (arg0.equals("i")) {
			impression = null;
		} else if (arg0.equals("d")) {
			document = null;
		} else if (arg0.equals("a")) {
			alimentation = null;
		} else if(arg0.equals("e")){
			envoiNumerisation = null;
		}
	}

	@Override
	public void numerisation() {
		// TODO Auto-generated method stub
		
	}

}
