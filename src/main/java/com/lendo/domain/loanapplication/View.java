package com.lendo.domain.loanapplication;


/**
 * This interface defines different Views for different models in application.
 * 
 * *
 */
public interface View {
	/**
	 * Enclosing type to define user views
	 */
	public static interface UserView {

		/**
		 * View for external users
		 */
		public static interface ApplicationView {
		}

		/**
		 * View for internal services/uses
		 */
		public static interface JobView  {
		}

}
}
