package com.classplusapp.web.pages;

import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.RemoteWebElement;

public class WebElement extends RemoteWebElement {

	public void click() {
		super.execute(DriverCommand.CLICK_ELEMENT(id));
	}

}
