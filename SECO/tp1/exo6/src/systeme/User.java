package systeme;

import interfaces.RequestImpression;
import interfaces.RequestNumerisation;

import org.objectweb.fractal.api.NoSuchInterfaceException;
import org.objectweb.fractal.api.control.BindingController;
import org.objectweb.fractal.api.control.IllegalBindingException;
import org.objectweb.fractal.api.control.IllegalLifeCycleException;

public class User implements Runnable, BindingController {
	private RequestImpression impression;
	private RequestNumerisation numerisation;

	@Override
	public void bindFc(String arg0, Object arg1)
			throws NoSuchInterfaceException, IllegalBindingException,
			IllegalLifeCycleException {
		if (arg0.equals("i")) {
			impression = (RequestImpression) arg1;
		} else if (arg0.equals("n")) {
			numerisation = (RequestNumerisation) arg1;
		}
	}

	@Override
	public String[] listFc() {
		return new String[] { "i", "n" };
	}

	@Override
	public Object lookupFc(String arg0) throws NoSuchInterfaceException {
		if (arg0.equals("i")) {
			return impression;
		} else if (arg0.equals("n")) {
			return numerisation;
		}
		return null;
	}

	@Override
	public void unbindFc(String arg0) throws NoSuchInterfaceException,
			IllegalBindingException, IllegalLifeCycleException {
		if (arg0.equals("i")) {
			impression = null;
		} else if (arg0.equals("n")) {
			numerisation = null;
		}
	}

	@Override
	public void run() {
		System.out.println("Lancement de l'impression");
		impression.impression();
	}

}
