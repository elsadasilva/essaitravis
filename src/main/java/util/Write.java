package util;

import hopital.HopitalFrame;

public class Write {



	public void w(String s) {
		HopitalFrame.getMyField().append(s+"\n");
	}

	public void ww(String s) {
		HopitalFrame.getMyField().setText(s+"\n");
	}
}
