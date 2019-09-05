/**
 * 
 */
package com.madhu.rest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import com.madhu.rest.Models.Student;
import com.madhu.rest.POJO.Word;
import com.madhu.rest.commands.StudentCommand;
import com.madhu.rest.converters.StudentMdlToCmdConverter;
import com.madhu.rest.converters.StudentCmdToMdlConverter;
import com.madhu.rest.repositories.StudentRepository;
import com.madhu.rest.service.MyRestService;

/**
 * @author ramachandranm1
 *
 */
@Service
public class MyRestServiceImpl implements MyRestService {

	private StopWatch watch = new StopWatch();
	private StudentRepository repo;
	private final StudentCmdToMdlConverter studentCmdToMdlConverter;
	private final StudentMdlToCmdConverter studentMdlToCmdConverter;

	public List<Word> findNoOfOccurance(String s) {
		// TODO Auto-generated method stub
		watch.start();
		String[] str = s.split("\\s");
		TreeMap<String, Word> map = new TreeMap<String, Word>();
		for (String a : str) {
			if (map.containsKey(a)) {
				Word w = map.get(a);
				w.setN(w.getN() + 1);
				map.put(a, w);
			} else
				map.put(a, new Word(a, 1));
		}
		//map.forEach((k, v) -> System.out.println(k + "->" + v.getN()));
		List<Word> words = new ArrayList<Word>();
		map.forEach((k, v) -> words.add(v));
		watch.stop();
		System.out.println(String.format("Time Taken : %d", watch.getTotalTimeMillis()));
		return words;
	}

	@Override
	public StudentCommand save(StudentCommand student) {
		Student model = studentCmdToMdlConverter.convert(student);
		return studentMdlToCmdConverter.convert(repo.save(model));
	}

	public MyRestServiceImpl(StudentRepository repo, StudentCmdToMdlConverter studentCmdToMdlConverter,
			StudentMdlToCmdConverter studentMdlToCmdConverter) {
		this.repo = repo;
		this.studentCmdToMdlConverter = studentCmdToMdlConverter;
		this.studentMdlToCmdConverter = studentMdlToCmdConverter;
	}

	@Override
	public StudentCommand fetchStudent(String id) {
		return studentMdlToCmdConverter.convert(repo.findById(new Long(id)).get());
	}
}
