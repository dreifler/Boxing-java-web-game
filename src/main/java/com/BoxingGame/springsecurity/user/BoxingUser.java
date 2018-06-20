package com.BoxingGame.springsecurity.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BoxingUser {

	 	@NotNull(message="is requird")
	 	@Size(min=1, message="is required")
	 	private String userName;
	 	
	 	@NotNull(message="is requird")
	 	@Size(min=1, message="is required")
	 	private String password;
	 	
	 	

		public BoxingUser() { }

		public BoxingUser(@NotNull(message = "is requird") @Size(min = 1, message = "is required") String userName,
				@NotNull(message = "is requird") @Size(min = 1, message = "is required") String password) {
			this.userName = userName;
			this.password = password;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public String toString() {
			return "BoxingUser [userName=" + userName + ", password=" + password + "]";
		}
	 	
	 	
}
