
public class Pokemon
	{
		private String name;
		private int number;
		private String type;
		private String skill1;
		private int Skill1Power;
		private String skill2;
		private int Skill2Power;
		private String skill3;
		private int Skill3Power;
		private String skill4;
		private int Skill4Power;
		private int level;
		private int experiencePoint;
		private int healthPoint;
		private int attackPoint;
		private int defencePoint;
		
		public Pokemon(String na, int nu, String t, String s1, int s1p, String s2, int s2p, String s3, int s3p, String s4, int s4p, int l, int ex, int hp, int ap, int dp )
		{
			name = na;
			number = nu;
			type = t;
			skill1 = s1;
			Skill1Power = s1p;
			skill2 = s2;
			Skill2Power = s2p;
			skill3 = s3;
			Skill3Power = s3p;
			skill4 = s4;
			Skill4Power = s4p;
			level = l;
			experiencePoint = ex;
			healthPoint = hp;
			attackPoint = ap;
			defencePoint = dp;
			
		}

		public int getSkill1Power()
			{
				return Skill1Power;
			}

		public void setSkill1Power(int skill1Power)
			{
				Skill1Power = skill1Power;
			}

		public int getSkill2Power()
			{
				return Skill2Power;
			}

		public void setSkill2Power(int skill2Power)
			{
				Skill2Power = skill2Power;
			}

		public int getSkill3Power()
			{
				return Skill3Power;
			}

		public void setSkill3Power(int skill3Power)
			{
				Skill3Power = skill3Power;
			}

		public int getSkill4Power()
			{
				return Skill4Power;
			}

		public void setSkill4Power(int skill4Power)
			{
				Skill4Power = skill4Power;
			}

		public String getSkill1()
			{
				return skill1;
			}

		public void setSkill1(String skill1)
			{
				this.skill1 = skill1;
			}

		public String getSkill2()
			{
				return skill2;
			}

		public void setSkill2(String skill2)
			{
				this.skill2 = skill2;
			}

		public String getSkill3()
			{
				return skill3;
			}

		public void setSkill3(String skill3)
			{
				this.skill3 = skill3;
			}

		public String getSkill4()
			{
				return skill4;
			}

		public void setSkill4(String skill4)
			{
				this.skill4 = skill4;
			}

		public String getName()
			{
				return name;
			}

		public void setName(String name)
			{
				this.name = name;
			}

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		public String getType()
			{
				return type;
			}

		public void setType(String type)
			{
				this.type = type;
			}

		public int getLevel()
			{
				return level;
			}

		public void setLevel(int level)
			{
				this.level = level;
			}

		public int getExperiencePoint()
			{
				return experiencePoint;
			}

		public void setExperiencePoint(int experiencePoint)
			{
				this.experiencePoint = experiencePoint;
			}

		public int getHealthPoint()
			{
				return healthPoint;
			}

		public void setHealthPoint(int healthPoint)
			{
				this.healthPoint = healthPoint;
			}

		public int getAttackPoint()
			{
				return attackPoint;
			}

		public void setAttackPoint(int attackPoint)
			{
				this.attackPoint = attackPoint;
			}

		public int getDefencePoint()
			{
				return defencePoint;
			}

		public void setDefencePoint(int defencePoint)
			{
				this.defencePoint = defencePoint;
			}
		
		

	}

