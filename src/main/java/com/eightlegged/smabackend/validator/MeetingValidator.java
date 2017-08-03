package com.eightlegged.smabackend.validator;

import java.sql.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.eightlegged.smabackend.model.CreateMeetingModel;

@Component(value = "meetingValidator")
public class MeetingValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return arg0.equals(CreateMeetingModel.class);
	}

	@Override
	public void validate(Object arg0, Errors err) {
		// TODO Auto-generated method stub
		CreateMeetingModel cmm = (CreateMeetingModel) arg0;
		if (!checkEmptyValue(err, cmm)) {
			checkDateValue(err, cmm.getStartDate(), cmm.getEndDate());
		}
	}

	private void checkDateValue(Errors err, Date startDate, Date endDate) {
		if (startDate.after(endDate)) {
			err.rejectValue("startDate", "error.startDate.not.greater");
		}
	}

	private boolean checkEmptyValue(Errors err, CreateMeetingModel form) {
		boolean isError = false;
		if (form.getTitle().isEmpty()) {
			err.rejectValue("title", "error.title.not.empty");
			isError = true;
		}
		if (form.getSubTitle().isEmpty()) {
			err.rejectValue("subTitle", "error.subtitle.not.empty");
			isError = true;
		}
		if (form.getContent().isEmpty()) {
			err.rejectValue("content", "error.content.not.empty");
			isError = true;
		}
		if (form.getStartDate() == null) {
			err.rejectValue("startDate", "error.startDate.not.empty");
			isError = true;
		}
		if (form.getEndDate() == null) {
			err.rejectValue("endDate", "error.endDate.not.empty");
			isError = true;
		}
		return isError;
	}

}
