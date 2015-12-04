package mouseactivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Native {
	private static Boolean loaded = null;

	static boolean load() {
		if(loaded!=null)
			return loaded==Boolean.TRUE;

		String libpath = System.getProperty("de.ksquared.system.mouse.lib.path"),
				   libname = System.getProperty("de.ksquared.system.mouse.lib.name");
		if(libname==null)
			libname = System.mapLibraryName("mousehook");
		try {
			if(libpath==null)
				   System.loadLibrary("mousehook");
			else System.load(new File(libpath,libname).getAbsolutePath());
			return (loaded=Boolean.TRUE);
		}	catch(UnsatisfiedLinkError e) { /* do nothing, try next */ }

		String osname = System.getProperty("os.name").toLowerCase(),
				   osarch = System.getProperty("os.arch");
		     if(osname.startsWith("mac os")) { osname = "mac"; osarch = "universal"; }
		else if(osname.startsWith("windows")) osname = "win";
		else if(osname.startsWith("sunos")) osname = "solaris";
		if(osarch.startsWith("i")&&osarch.endsWith("86"))
			osarch = "x86";
		libname = "mousehook-"+osname+'-'+osarch+".lib";
		try {
			InputStream input = Native.class.getClassLoader().getResourceAsStream(libname);
			if(input==null)
				throw new Exception("libname: "+libname+" not found");
			File temp = File.createTempFile("mousehook-",".lib");
			temp.deleteOnExit();
			OutputStream out = new FileOutputStream(temp);
			byte[] buffer = new byte[1024];
			int read;
			while((read = input.read(buffer))!=-1)
				out.write(buffer,0,read);
			input.close(); out.close();
			System.load(temp.getAbsolutePath());
			return (loaded=Boolean.TRUE);
		} catch(Exception e) { /* do nothing, go on */ }
		return (loaded=Boolean.FALSE);
	}
}