import org.objectweb.fractal.api.Component;
import org.objectweb.fractal.api.factory.*;
import org.objectweb.fractal.api.type.ComponentType;
import org.objectweb.fractal.api.type.InterfaceType;
import org.objectweb.fractal.api.type.TypeFactory;

import org.objectweb.fractal.util.Fractal;

public class MonServer {
	public static void main(String[] args) {

		try {
			Component boot = Fractal.getBootstrapComponent();

			TypeFactory tf = (TypeFactory) boot.getFcInterface("type-factory");
			GenericFactory cf = (GenericFactory) boot
					.getFcInterface("generic-factory");

			// cr�er le composite
			// interface server "r" / "java.lang.Runnable"
			ComponentType compositeType = tf
					.createFcType(new InterfaceType[] { tf.createFcItfType("r",
							"java.lang.Runnable", false, false, false) });

			Component composite = cf.newFcInstance(compositeType, "composite",
					null);

			// créer le primitif RequestReceiver
			// interface server "r" / "java.lang.Runnable"
			// interface client "rh" / "comanche.RequestHandler"
			// interface client "s" / "comanche.Scheduler"
			// implementation "comanche.RequestReceiver"
			ComponentType requestReceiverType = tf
					.createFcType(new InterfaceType[] {
							tf.createFcItfType("r", "java.lang.Runnable",
									false, false, false),
							tf.createFcItfType("rh", "comanche.RequestHandler",
									true, false, false),
							tf.createFcItfType("s", "comanche.Scheduler", true,
									false, false) });
			Component requestReceiver = cf.newFcInstance(requestReceiverType,
					"primitive", "comanche.RequestReceiver");

			// créer le primitif RequestAnalyzer
			// interface server "a" / "comanche.RequestHandler"
			// interface client "l" / "comanche.Logger"
			// interface client "rh" / "comanche.RequestHandler"
			// implementation "comanche.RequestAnalyser"
			ComponentType requestAnalyserType = tf
					.createFcType(new InterfaceType[] {
							tf.createFcItfType("a", "comanche.RequestHandler",
									false, false, false),
							tf.createFcItfType("l", "comanche.Logger", true,
									false, false),
							tf.createFcItfType("rh", "comanche.RequestHandler",
									true, false, false) });
			Component requestAnalyzer = cf.newFcInstance(requestAnalyserType,
					"primitive", "comanche.RequestAnalyzer");

			// créer le primitif Scheduler
			// interface server "s" / "comanche.Scheduler"
			// implementation "comanche.MultiThreadScheduler"
			ComponentType schedulerType = tf
					.createFcType(new InterfaceType[] { tf.createFcItfType("s",
							"comanche.Scheduler", false, false, false) });
			Component scheduler = cf.newFcInstance(schedulerType, "primitive",
					"comanche.MultiThreadScheduler");

			// créer le primitif Logger
			// interface server "l" / "comanche.Logger"
			// implementation "comanche.BasicLogger"
			ComponentType loggerType = tf.createFcType(new InterfaceType[] { tf
					.createFcItfType("l", "comanche.Logger", false, false,
							false) });
			Component logger = cf.newFcInstance(loggerType, "primitive",
					"comanche.BasicLogger");

			// créer le primitif FileRequestHandler
			// interface server "rh" / "comanche.RequestHandler"
			// implementation "comanche.FileRequestHandler"
			ComponentType fileRequestHandlerType = tf
					.createFcType(new InterfaceType[] { tf.createFcItfType(
							"rh", "comanche.RequestHandler", false, false,
							false) });
			Component fileRequestHandler = cf.newFcInstance(
					fileRequestHandlerType, "primitive",
					"comanche.FileRequestHandler");

			// ajouter les sous-composants au composite
			Fractal.getContentController(composite).addFcSubComponent(
					requestReceiver);
			Fractal.getContentController(composite).addFcSubComponent(
					requestAnalyzer);
			Fractal.getContentController(composite)
					.addFcSubComponent(scheduler);
			Fractal.getContentController(composite).addFcSubComponent(logger);
			Fractal.getContentController(composite).addFcSubComponent(
					fileRequestHandler);

			// lier les sous-composants
			Fractal.getBindingController(composite).bindFc("r",
					requestReceiver.getFcInterface("r"));
			Fractal.getBindingController(requestReceiver).bindFc("rh",
					requestAnalyzer.getFcInterface("a"));
			Fractal.getBindingController(requestReceiver).bindFc("s",
					scheduler.getFcInterface("s"));
			Fractal.getBindingController(requestAnalyzer).bindFc("l",
					logger.getFcInterface("l"));
			Fractal.getBindingController(requestAnalyzer).bindFc("rh",
					fileRequestHandler.getFcInterface("rh"));

			// démarrer
			Fractal.getLifeCycleController(composite).startFc();

			Thread t = new Thread((Runnable) composite.getFcInterface("r"));
			t.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
