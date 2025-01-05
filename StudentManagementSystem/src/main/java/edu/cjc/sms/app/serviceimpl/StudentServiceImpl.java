package edu.cjc.sms.app.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cjc.sms.app.model.Student;
import edu.cjc.sms.app.repository.StudentRepo;
import edu.cjc.sms.app.servicei.StudentServiceI;

@Service
public class StudentServiceImpl implements StudentServiceI {

	@Autowired
	StudentRepo sr;

	@Override
	public List<Student> addStudent(Student s) {
		sr.save(s);

		return sr.findAll();
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return sr.findAll();
	}

	@Override
	public List<Student> getBatchesStudent(String batchNumber) {

		List<Student> list = sr.findAllByBatchNumber(batchNumber);
		return list;
	}

	@Override
	public Student getStudent(int id) {

		return sr.findById(id).get();
	}

	@Override
	public List<Student> updateStudentFees(int id, float amt) {

		Optional<Student> op = sr.findById(id);
		if (op.isPresent()) {
			Student s = op.get();
			s.setFeesPaid(s.getFeesPaid() + amt);
			sr.save(s);
		}
		List<Student> list = sr.findAll();
		return list;
	}

	@Override
	public void removeStudent(int id) {

		sr.deleteById(id);
	}

	@Override
	public List<Student> shiftBatch(int id) {
		
//		sr.deleteById(id);
//		sr.saveAll(id);
		
		return null;
	}

}
