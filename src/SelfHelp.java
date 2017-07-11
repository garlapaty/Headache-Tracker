
public class SelfHelp {
	private String name;
	private String avgEffectivity;
	
	public SelfHelp(String name, String avgEffectivity) {
		this.name = name;
		this.avgEffectivity = avgEffectivity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAvgEffectivity() {
		return avgEffectivity;
	}
	public void setAvgEffectivity(String avgEffectivity) {
		this.avgEffectivity = avgEffectivity;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avgEffectivity == null) ? 0 : avgEffectivity.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SelfHelp other = (SelfHelp) obj;
		if (avgEffectivity == null) {
			if (other.avgEffectivity != null)
				return false;
		} else if (!avgEffectivity.equals(other.avgEffectivity))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
