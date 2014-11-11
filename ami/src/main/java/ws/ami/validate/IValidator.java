package ws.ami.validate;

public interface IValidator
{
    /**
     * 返回多个错误
     * @param obj
     * @throws ValidationException
     */
    public void validateMutil(Object obj) throws ValidationException;

    /**
     * 返回单个错误
     * @param obj
     * @throws ValidationException
     */
    public void validate(Object obj) throws ValidationException;
}