package com.capgemini.addressbook;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class AddressBookTest {

	@Test
	public void given3Contacts_WhenWrittenToFile_ShouldMatchContactEntries() {

		ContactDetails infoOne = new ContactDetails("Diya", "Narayan", "Ammerpet", "Hyderabad", "Telangana", 534876,
				1828840516, "diyanarayanl@gmail.com");
		ContactDetails infoTwo = new ContactDetails("Teju", "Reddy", "Sai nagar", "Annatapur", "Anantapur", 652341,
				80083634, "TejuReddy@gamil.com");
		ContactDetails infoThree = new ContactDetails("Yodha", "Rakshitha", "MR peta", "Kanchipuram", "TamlNadu",
				522430, 798265341, "rakshitha.yodha1@gmailcom");
		List<ContactDetails> contactDetailsList = Arrays.asList(new ContactDetails[] { infoOne, infoTwo, infoThree });
		AddressBookFileIOService addressBookFileIOService = new AddressBookFileIOService();
		addressBookFileIOService.writeData(contactDetailsList);
		addressBookFileIOService.printEntries();
		List<ContactDetails> readContacts = addressBookFileIOService.readEntries();
		System.out.println(readContacts);
		Assert.assertEquals(infoOne.toString(), readContacts.get(0).toString());
		Assert.assertEquals(infoTwo.toString(), readContacts.get(1).toString());
		Assert.assertEquals(infoThree.toString(), readContacts.get(2).toString());
	}
}
