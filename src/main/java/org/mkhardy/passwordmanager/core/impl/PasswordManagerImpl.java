package org.mkhardy.passwordmanager.core.impl;

import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.codec.digest.DigestUtils;
import org.mkhardy.passwordmanager.core.PasswordManager;
import org.mkhardy.passwordmanager.core.beans.PasswordRule;
import org.mkhardy.passwordmanager.core.beans.impl.Answer;
import org.mkhardy.passwordmanager.core.beans.impl.Password;
import org.mkhardy.passwordmanager.core.beans.impl.Question;

public class PasswordManagerImpl implements PasswordManager {
	private List<Question> questions;
	private List<PasswordRule> passwordRules;
	
	public PasswordManagerImpl(List<Question> questions, List<PasswordRule> passwordRules) {
		this.questions = questions;
		this.passwordRules = passwordRules;
	}

	public boolean isValidPassword(Password password) throws PasswordRuleException {
		for(PasswordRule passwordRule:passwordRules) {
			passwordRule.isValidPassword(password);
		}
		return true;
	}

	@Override
	public byte[] hashPassword(Password password) {
		return DigestUtils.sha256(password.getValue());
	}

	@Override
	public byte[] hashAnswers(List<Answer> answers) {
		StringBuilder answerBuilder = new StringBuilder();
		for(Answer answer:answers) {
			answerBuilder.append(answer.getValue());
		}
		return DigestUtils.sha256(answerBuilder.toString());
	}

	@Override
	public List<Question> getQuestions() {
		return this.questions;
	}
	
	
}