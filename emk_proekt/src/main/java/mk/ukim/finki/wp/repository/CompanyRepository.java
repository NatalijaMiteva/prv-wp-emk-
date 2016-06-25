package mk.ukim.finki.wp.repository;

import mk.ukim.finki.wp.model.Company;
import mk.ukim.finki.wp.model.Person;

public interface CompanyRepository extends JpaSpecificationRepository<Company> {

	Person findByOwnerEmbg(String embg);

}
