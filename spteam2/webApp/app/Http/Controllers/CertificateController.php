<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Certification;
use DB;
class CertificateController extends Controller
{

 

    public function index() {
       // $certifications = Certification::orderBy('Date','desc')->get();
        //return view('certificates.index')->with('certifications',$certifications);

        $certifications = DB::select('select distinct *
        from CERTIFICATION
        join EMPLOYEE on CERTIFICATION.EmployeeID = EMPLOYEE.EmployeeID
        join TRAINING on TRAINING.TrainingID = CERTIFICATION.TrainingID ORDER BY Date Desc');
 
      return view('certificates.index')->with('certifications',$certifications);
    }


    public function create() {

        return view('certificates.create');
    }

    public function store(Request $request) {

        $this->validate($request,[
            'CertificationName' => 'required|max:30',
            'CertificationType' => 'required|max:30',
            'Date' => 'required',
            'TrainingID' => 'required',
            'EmployeeID' => 'required',
            'image' => 'image|nullable|max:1999'
       ]);

       //handle file upload
       if($request->hasFile('Image')) {
        // Get filename with the extension
        $filenameWithExt = $request->file('Image')->getClientOriginalName();
        //Get just filename
        $filename = pathinfo($filenameWithExt, PATHINFO_FILENAME);
        //Get just extension
        $extension = $request->file('Image')->getClientOriginalExtension();
        //filename to store
        $fileNameToStore = $filename.'_'.time().'.'.$extension;
        //upload image
        $path = $request->file('Image')->storeAs('public/images', $fileNameToStore);
    } else {
        $fileNameToStore='noimage.jpg';

    }
       //Create new post
       $certification = new Certification;
       $certification->CertificationName = $request->input('CertificationName');
       $certification->CertificationType = $request->input('CertificationType');
       $certification->Date = $request->input('Date');
       $certification->TrainingID = $request->input('TrainingID');
       $certification->EmployeeID = $request->input('EmployeeID');
       $certification->Image = $fileNameToStore;
       $certification->save();
       return redirect('/certifications')->with('success', 'Certificate inserted');
    }

    public function show($CertificationID) {

        $certifications =  Certification::find($CertificationID);
        return view('certificates.show')->with('certifications',$certifications);
    }
}
