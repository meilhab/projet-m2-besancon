package systeme;

import org.objectweb.fractal.api.NoSuchInterfaceException;
import org.objectweb.fractal.api.control.BindingController;
import org.objectweb.fractal.api.control.IllegalBindingException;
import org.objectweb.fractal.api.control.IllegalLifeCycleException;

import interfaces.RequestAlim;
import interfaces.RequestDoc;
import interfaces.RequestInput;
import interfaces.RequestNumerisation;

public class Numerisation implements RequestNumerisation, BindingController {
	private RequestInput input;
	private RequestDoc document;
	private RequestAlim alimentation;
	
	@Override
	public void bindFc(String arg0, Object arg1)
			throws NoSuchInterfaceException, IllegalBindingException,
			IllegalLifeCycleException {
		if (arg0.equals("in")) {
			input = (RequestInput) arg1;
		} else if (arg0.equals("d")) {
			document = (RequestDoc) arg1;
		} else if (arg0.equals("a")) {
			alimentation = (RequestAlim) arg1;
		}
	}

	@Override
	public String[] listFc() {
		return new String[] { "in", "d", "a" };
	}

	@Override
	public Object lookupFc(String arg0) throws NoSuchInterfaceException {
		if (arg0.equals("in")) {
			return input;
		} else if (arg0.equals("d")) {
			return document;
		} else if (arg0.equals("a")) {
			return alimentation;
		}
		return null;
	}

	@Override
	public void unbindFc(String arg0) throws NoSuchInterfaceException,
			IllegalBindingException, IllegalLifeCycleException {
		if (arg0.equals("in")) {
			input = null;
		} else if (arg0.equals("d")) {
			document = null;
		} else if (arg0.equals("a")) {
			alimentation = null;
		}
	}

	@Override
	public void numerisation() {
		// TODO Auto-generated method stub
		
	}

}
