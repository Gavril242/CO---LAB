package bench.cpu;

import bench.IBenchmark;

public class CPUFixedVsFloatingPoint implements IBenchmark {

	//private int result;
	private long size;
	int num[], res[];


	/**
	 * @param
	 */
	@Override
	public void run() {
		Integer_arithmetic_test();
		Branching_test();

	}

	@Override
	public void run(Object... param) {

	}

	/**
	 * @param params
	 */
	@Override
	public void initialize(Object... params) {
		size = (long)params[0];
		num = new int[(int)size];
		res = new int[(int)size];

	}

	/**
	 *
	 */
	@Override
	public void clean() {

	}

	/**
	 *
	 */
	@Override
	public void cancel() {

	}

	/**
	 *
	 */
	@Override
	public void warmup() {

	}

	public void Integer_arithmetic_test(){
		int i, j=1, k=2, l=3;

		for(i=0;i<size;i++) {
			j = num[1] * (k - j) * (l - k);
			k = num[3] * k - (l - j) * k;
			l = (l - k) * (num[2] + j);
			res[l - 2] = j + k + l;
			res[k - 2] = j * k * l;
		}
	}

	public void Branching_test(){

	}

	public void Array_access_and_assignments(){

	}


}

