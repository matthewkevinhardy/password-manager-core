package to.uk.mkhardy.passwordmanager.core;

import java.util.List;

import to.uk.mkhardy.passwordmanager.core.beans.impl.Answer;
import to.uk.mkhardy.passwordmanager.core.beans.impl.Password;
import to.uk.mkhardy.passwordmanager.core.beans.impl.Question;
import to.uk.mkhardy.passwordmanager.core.beans.impl.User;
import to.uk.mkhardy.passwordmanager.core.impl.PasswordRuleException;

public interface PasswordManager {
	
	public boolean isValidPassword(String password) throws PasswordRuleException;
	
	public Answer getAnswer(String value,User user,Question question);
	
	public Password getPassword(String value,User user);
	
	//public SecretKey getAnswerKey(List<Answer> answers,User user) throws NoSuchAlgorithmException, InvalidKeySpecException;
	public List<Question> getQuestions();
	
	public String encrypt(byte[] pText, List<String> answers, User user) throws Exception;

	public String encrypt(byte[] pText, String password) throws Exception;

	public String decrypt(String cText, String password) throws Exception;
	
	public String decrypt(String pText, List<String> answers, User user) throws Exception;
}
