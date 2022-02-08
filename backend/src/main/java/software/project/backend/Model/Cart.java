package software.project.backend.Model;

public class Cart implements Imodel {
	    private String name;
	    private String description;
	    private double price;
	    private int noOfCopies;
	    private String image;

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

	    public double getPrice() {
	        return price;
	    }

	    public void setPrice(double price) {
	        this.price = price;
	    }

	public int getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}

	public String getImage() {
	        return image;
	    }

	    public void setImage(String image) {
	        this.image = image;
	    }
}
