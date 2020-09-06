/*PROJECT_NAME | ROLL_NUMBER | YOUR_NAME
This is the model class of Medicine which all medicine attributes and their getter setter (also known as POJO class in java)
This class inherits Stock class.
*/
package MODEL;

public class Medicine extends Stock {
    private String name, description, formula, manufacturer;
    private boolean isSensitive;

    public Medicine() {
        name = description = formula = manufacturer = "";
        isSensitive = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public boolean isSensitive() {
        return isSensitive;
    }

    public void setSensitive(boolean sensitive) {
        isSensitive = sensitive;
    }
}
