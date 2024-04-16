package Heroku.Project.Converter;

import Heroku.Project.Tables.PaymentModel;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PaymentModelConverter implements AttributeConverter<PaymentModel, String> {

    @Override
    public String convertToDatabaseColumn(PaymentModel attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.name();
    }

    @Override
    public PaymentModel convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        try {
            return PaymentModel.valueOf(dbData.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null; // or throw an exception
        }
    }
}
