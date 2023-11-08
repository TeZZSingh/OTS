package gov.ifms.ots;

import io.helidon.microprofile.server.Server;
public class OTSMain {

	private OTSMain() { }
	public static void main(String[] args) {
		Server server = startServer();
		System.out.println("http://localhost:" + server.port());
	}
	static Server startServer() {
		return Server.create().start();
	}
}
