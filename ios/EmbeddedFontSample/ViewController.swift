//
//  ViewController.swift
//  EmbeddedFontSample
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var textUrl: UITextField!

    override func viewDidLoad() {
        super.viewDidLoad()

        textUrl.text = "https://m-kann0.github.io/EmbeddedFontSample/sample2.html"
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        guard segue.identifier == "moveToWebView" else {
            return
        }
        
        let dest = segue.destination as! WebViewController
        dest.url = textUrl.text
    }
}
